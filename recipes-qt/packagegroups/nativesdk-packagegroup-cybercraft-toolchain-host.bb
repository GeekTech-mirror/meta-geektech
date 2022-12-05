DESCRIPTION = "Qt6 development host packages"
LICENSE = "MIT"

# disable sanity check for allarch packagegroup
#PACKAGE_ARCH = ""

inherit packagegroup nativesdk

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

RDEPENDS:${PN} += " \
    ${LINUX_HOST} \
    ${QT_HOST} \
    nativesdk-extra-cmake-modules-dev \
"

LINUX_HOST = " \
    nativesdk-make \
    nativesdk-cmake \
    nativesdk-ninja \
    nativesdk-perl-modules \
"

QT_HOST = " \
    nativesdk-qtbase-dev \
    nativesdk-qtbase-tools \
    nativesdk-qtdeclarative-dev \
    nativesdk-qtdeclarative-tools \
    nativesdk-qttools-dev \
    nativesdk-qttools-tools \
"