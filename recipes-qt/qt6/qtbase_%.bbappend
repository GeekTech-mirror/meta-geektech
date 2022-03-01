# Set whether to use build opengl for 'x11', 'eglfs', and/or 'kms'
PACKAGECONFIG_GL:rpi = 
    "${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'gl', \
        bb.utils.contains('DISTRO_FEATURES', 'opengl', 'eglfs gles2', '', d), d)}"
PACKAGECONFIG_GL:append:rpi = " ${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', ' kms', '', d)}"
PACKAGECONFIG_GL:append:rpi = " gbm"
PACKAGECONFIG_FONTS:rpi = "fontconfig"
PACKAGECONFIG:append:rpi = " gbm libinput tslib xkbcommon"

PACKAGECONFIG += " cups glib sql-sqlite" 
PACKAGECONFIG += " ${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', ' kms', '', d)}"

OE_QTBASE_EGLFS_DEVICE_INTEGRATION:rpi = "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', 'eglfs_kms', 'eglfs_brcm', d)}"

# Set addition specs for the raspberry pi
do_configure:prepend() {
    cat > ${S}/mkspecs/oe-device-extra.pri << EOF
    QMAKE_LIBS_EGL += -lEGL
    QMAKE_LIBS_OPENGL_ES2 += -lGLESv2 -lEGL

    DISTRO_OPTS += hard-float
    DISTRO_OPTS += deb-multi-arch

    # Preferred backend
    QT_QPA_DEFAULT_PLATFORM = eglfs

EOF

    if [ "${@d.getVar('OE_QTBASE_EGLFS_DEVICE_INTEGRATION')}" != "" ]; then
        echo "EGLFS_DEVICE_INTEGRATION = ${OE_QTBASE_EGLFS_DEVICE_INTEGRATION}" >> ${S}/mkspecs/oe-device-extra.pri
    fi

}
RDEPENDS:${PN}:append:rpi = "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '', ' userland', d)}"
DEPENDS:append:rpi = "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '', ' userland', d)}"