package com.reactlibrary;

import android.util.Log;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;

public class PromiseExceptionManager {

    /**
     * resolvePromiseException
     * @param clientExcepion
     * @param serviceException
     * @param promise
     */
    public static void resolvePromiseException(ClientException clientExcepion, ServiceException serviceException, final Promise promise) {
        if (clientExcepion != null) {
            clientExcepion.printStackTrace();
            promise.reject(clientExcepion);
        }
        if (serviceException != null) {
            Log.e("ErrorCode", serviceException.getErrorCode());
            Log.e("RequestId", serviceException.getRequestId());
            Log.e("HostId", serviceException.getHostId());
            Log.e("RawMessage", serviceException.getRawMessage());
            WritableMap info = new WritableNativeMap();
            info.putString("ErrorCode", serviceException.getErrorCode());
            info.putString("RequestId", serviceException.getRequestId());
            info.putString("HostId", serviceException.getHostId());
            info.putString("RawMessage", serviceException.getRawMessage());
            promise.reject(serviceException, info);
        }
    }
}