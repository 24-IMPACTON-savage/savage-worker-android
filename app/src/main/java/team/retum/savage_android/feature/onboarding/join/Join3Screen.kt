package team.retum.savage_android.feature.onboarding.join

import android.Manifest
import android.content.pm.PackageManager
import android.os.Looper
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.launch
import team.retum.savage_android.data.RetrofitClient
import team.retum.savage_android.model.request.SignUpRequest
import team.retum.savage_android.ui.component.SavageAppBar
import team.retum.savage_android.ui.component.SavageButton
import team.retum.savage_android.ui.component.SavageTextField
import team.retum.savage_android.ui.theme.SavageTypography
import team.retum.savage_android.ui.theme.rememberKeyboardIsOpen
import team.retum.savage_android.util.Constant
import team.retum.savage_android.util.PermissionUtil

@Composable
private fun Title() {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp)
    ) {
        Text(
            text = "농부분들이 뭐라고 불러야 할까요?",
            style = SavageTypography.HeadLine1
        )
    }
}

@Composable
fun Join3Screen(
    navController: NavController,
    name: String,
    country: String,
    tel: String
) {
    val context = LocalContext.current

    var nickName by remember { mutableStateOf("") }
    val keyboardShow by rememberKeyboardIsOpen()

    var latitude by remember {
        mutableStateOf<Double?>(null)
    }

    var longitude by remember {
        mutableStateOf<Double?>(null)
    }

    var isAllowLocationPermission by rememberSaveable { mutableStateOf(false) }

    val locationPermissions = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    val launcherMultiplePermissions = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissionsMap ->
        if (permissionsMap.values.isEmpty()) return@rememberLauncherForActivityResult
        val areGranted = permissionsMap.values.reduce { acc, next -> acc && next }
        isAllowLocationPermission = areGranted
    }

    LaunchedEffect(true) {
        PermissionUtil.requestPermissions(context, locationPermissions, launcherMultiplePermissions)
    }
    val coroutine = rememberCoroutineScope()
    // 마지막 위치 불러오는 함수
    val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locations: LocationResult) {
            for (l in locations.locations) {
//                currentLocation = LatLng.from(location.latitude, location.longitude)
                latitude = l.latitude
                longitude = l.longitude
                Log.d(
                    Constant.TAG,
                    "w - ${l.latitude} g - ${l.longitude} - onLocationResult() called"
                )
            }
        }
    }

    val fusedLocationClient by remember {
        mutableStateOf(
            LocationServices.getFusedLocationProviderClient(
                context
            )
        )
    }

    fun getAllowLocationPermission() = ActivityCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    fun locationUpdate() {
        if (!getAllowLocationPermission()) return

        val locationRequest = LocationRequest.Builder(1000) // 1초마다 체크
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
            .build()

        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )
    }

    LaunchedEffect(isAllowLocationPermission) {
        if (isAllowLocationPermission) {
            locationUpdate()
        }
    }
    
    SavageAppBar(
        callback = {
            navController.popBackStack()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Title()
            Spacer(modifier = Modifier.padding(top = 48.dp))
            SavageTextField(
                modifier = Modifier.padding(horizontal = 20.dp),
                value = nickName,
                hint = "뭐라고 불러야 할 지 알려주세요!",
                onValueChange = { nickName = it })
            Spacer(modifier = Modifier.weight(1f))
            SavageButton(
                modifier = if (!keyboardShow) Modifier.padding(horizontal = 16.dp) else Modifier,
                onClick = {
                    if (nickName.isNotBlank()) {
                        coroutine.launch {
                            RetrofitClient.userApi.signUp(
                                SignUpRequest(
                                    contact = tel,
                                    name = name,
                                    passport = "123123-876523",
                                    introduce = nickName,
                                    country = country,
                                    latitude = latitude ?: 0.0,
                                    longitude = longitude ?: 0.0
                                )
                            )
                            navController.popBackStack()
                        }
                    } else {
                        // handling
                    }
                },
                text = "다음",
                isAbleClick = nickName.isNotBlank(),
                isKeyShow = keyboardShow
            )
            if (!keyboardShow)
                Spacer(modifier = Modifier.padding(bottom = 24.dp))
        }
    }
}
