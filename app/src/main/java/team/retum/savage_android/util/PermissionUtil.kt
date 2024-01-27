package team.retum.savage_android.util

import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.core.content.ContextCompat
import team.retum.savage_android.util.Constant.TAG

object PermissionUtil {
    fun requestPermissions(
        context: Context,
        permissions: Array<String>,
        launcher: ManagedActivityResultLauncher<Array<String>, Map<String, Boolean>>,
    ) {
        // 권한이 이미 있는 경우
        if (permissions.all {
                ContextCompat.checkSelfPermission(
                    context,
                    it
                ) == PackageManager.PERMISSION_GRANTED
            }) {
            Log.d(TAG, "권한이 이미 존재합니다.")
            launcher.launch(permissions)
        }
        // 권한이 없는 경우
        else {
            launcher.launch(permissions)
            Log.d(TAG, "권한을 요청하였습니다.")
        }
    }
}