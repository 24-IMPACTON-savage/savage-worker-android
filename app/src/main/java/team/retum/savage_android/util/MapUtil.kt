package team.retum.savage_android.util

import android.content.Context
import android.location.Geocoder
import android.location.LocationManager
import android.view.LayoutInflater
import android.view.View
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.MapView
import com.kakao.vectormap.camera.CameraAnimation
import com.kakao.vectormap.camera.CameraPosition
import com.kakao.vectormap.camera.CameraUpdateFactory
import com.kakao.vectormap.label.LabelOptions
import com.kakao.vectormap.label.LabelStyle
import com.kakao.vectormap.label.LabelStyles
import team.retum.savage_android.R
import java.util.Locale

private fun getCurrentLocation(context: Context): Pair<Double, Double> {

    val permissionManager = PermissionManager()

    val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    val location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
        ?: throw NullPointerException()

    // TODO RuntimeException -> RevokePermissionException() 으로 변경
    return if (permissionManager.checkPermission(context)) {
        location.latitude to location.longitude
    } else throw RuntimeException()
}

internal fun setUserLocation(
    context: Context,
    kakaoMap: KakaoMap,
) {
    runCatching {
        getCurrentLocation(context)
    }.onSuccess { currentPosition ->
        kakaoMap.moveCamera(
            CameraUpdateFactory.newCameraPosition(
                CameraPosition.from(
                    currentPosition.first,
                    currentPosition.second,
                    0,
                    0.0,
                    10.0,
                    3000.0,
                ),
            ),
            CameraAnimation.from(500),
        )
    }.onFailure {
        when (it) {
            is NullPointerException -> {

            }
            // TODO RuntimeException -> RevokePermissionException() 으로 변경
            is RuntimeException -> {

            }
        }
    }
}

fun initMapView(context: Context, callback: (address: String) -> Unit): View {
    val view = LayoutInflater.from(context).inflate(
        /* resource = */ R.layout.select_position,
        /* root = */ null,
        /* attachToRoot = */ false,
    )

    val mapView = view.findViewById<MapView>(R.id.map_view)

    val list: List<Pair<Double, Double>> = listOf(
        37.394660 to 127.11118,
        39.394660 to 129.11118,
        41.394660 to 131.11118,
        43.394660 to 133.11118,
        45.394660 to 135.11118,
    )

    mapView.start(object : KakaoMapReadyCallback() {
        override fun onMapReady(kakaoMap: KakaoMap) {
            setUserLocation(
                context = context,
                kakaoMap = kakaoMap,
            )

            val geoCoder = Geocoder(context, Locale.KOREA)

            val labelManager = kakaoMap.labelManager
            val labelStyle = LabelStyle.from(R.drawable.ic_marker)
            val labelStyles = LabelStyles.from(labelStyle)
            val styles = labelManager?.addLabelStyles(labelStyles)

            val locationManager =
                context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

            val location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)

            list.forEach {

                val options = LabelOptions.from(
                    LatLng.from(
                        it.first,
                        it.second,
                    )
                ).setStyles(styles)

                val layer = labelManager?.layer
                layer?.addLabel(options)
                kakaoMap.setOnLabelClickListener { kakaoMap, layer, label ->
                    kakaoMap.cameraPosition?.position?.run {
                        geoCoder.getFromLocation(this.latitude, this.longitude, 1)?.run {
                            callback(this.first().getAddressLine(0))
                        }
                    }
                }
            }
        }
    })

    return view
}