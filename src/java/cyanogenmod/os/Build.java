/*
 * Copyright (C) 2015 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cyanogenmod.os;

import android.os.SystemProperties;
import android.util.SparseArray;

/**
 * Information about the current CyanogenMod build, extracted from system properties.
 */
public class Build {
    /** Value used for when a build property is unknown. */
    public static final String UNKNOWN = "unknown";

    private static final SparseArray<String> sdkMap;
    static
    {
        sdkMap = new SparseArray<String>();
        sdkMap.put(CM_VERSION_CODES.APRICOT, "Apricot");
    }

    /** Various version strings. */
    public static class CM_VERSION {
        /**
         * The user-visible SDK version of the framework; its possible
         * values are defined in {@link Build.CM_VERSION_CODES}.
         */
        public static final int SDK_INT = SystemProperties.getInt(
                "ro.cm.build.version.plat.sdk", 0);
    }

    /**
     * Enumeration of the currently known SDK version codes.  These are the
     * values that can be found in {@link CM_VERSION#SDK_INT}.  Version numbers
     * increment monotonically with each official platform release.
     */
    public static class CM_VERSION_CODES {
        /**
         * June 2015: The first version of the platform sdk for CyanogenMod
         */
        public static final int APRICOT = 1;
    }

    /**
     * Retrieve the name for the SDK int
     * @param sdkInt
     * @return name of the SDK int
     */
    public static String getNameForSDKInt(int sdkInt) {
        return sdkMap.get(sdkInt);
    }
}
