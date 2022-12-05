SUMMARY = "Miuzei Touchscreen (MPI4008)"
DESCRIPTION = "touchscreen drivers for Miuzei Rapsberry Pi 4 touchscreen"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/goodtft/LCD-show.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

# depends on touch screen library for input
#RDEPENDS:${PN} = "tslib tslib-calibrate"

# display calibration
#                             min-x max-x min-y max-y
#     Option  "Calibration"   "4023 83    137   3912"
#     Option  "SwapAxes"      "1"

FILES:${PN} += " \
    /etc/X11/xorg.conf.d/99-calibration.conf \
"

do_install () {
    #install -d ${D}/etc
    #install -m 755 ${B}/usr/inittab ${D}/etc/inittab

    #install -d ${D}/usr/share/X11/xorg.conf.d
    #install -m 755 ${B}/usr/99-fbturbo.conf-HDMI \
    #                ${D}/usr/share/X11/xorg.conf.d/99-fbturbo.conf

    install -d ${D}/etc/X11/xorg.conf.d
    install -m 755 ${B}/usr/99-calibration.conf-397-270 \
                   ${D}/etc/X11/xorg.conf.d/99-calibration.conf
}