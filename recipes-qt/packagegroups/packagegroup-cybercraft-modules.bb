DESCRIPTION = "Qt6 modules"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

RDEPENDS:${PN} += " \
    ${QT_TARGET_ESSENTIALS} \
    ${QT_TARGET_ESSENTIALS} \
"

QT_TARGET_ESSENTIALS = " \
    qtbase \
    qtdeclarative \
    qtdeclarative-tools \
    qttools \
    qttranslations-qtbase \
    qttranslations-qtdeclarative \
"

QT_TARGET_ADDONS = " \
    qtsvg \
"