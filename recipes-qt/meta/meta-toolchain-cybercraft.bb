SUMMARY = "Meta package for building an installable Qt6 toolchain and SDK"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit populate_sdk populate_sdk_qt6_base

TOOLCHAIN_HOST_TASK:append = " \
    nativesdk-packagegroup-qt6-toolchain-host \
    nativesdk-extra-cmake-modules-dev \
"

TOOLCHAIN_TARGET_TASK:append = " packagegroup-qt6-modules"


#TOOLCHAIN_HOST_TASK:append = " nativesdk-packagegroup-cybercraft-toolchain-host"
#TOOLCHAIN_TARGET_TASK:append = " packagegroup-cybercraft-modules"

