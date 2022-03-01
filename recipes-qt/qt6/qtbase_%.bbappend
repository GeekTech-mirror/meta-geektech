PACKAGECONFIG_GL:rpi = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'eglfs gles2', d)}"
PACKAGECONFIG_GL:append:rpi = " ${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'gl', d)}"
PACKAGECONFIG_GL:append:rpi = " ${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', ' kms', '', d)}"
PACKAGECONFIG_GL:append:rpi = " gbm"
PACKAGECONFIG_FONTS:rpi = "fontconfig"
PACKAGECONFIG:append:rpi = " gbm libinput tslib xkbcommon"

# try gles with x11
PACKAGECONFIG += " cups gles glib sql-sqlite" 
PACKAGECONFIG += " ${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', ' kms', '', d)}"

do_configure:prepend() {
    cat > ${S}/mkspecs/oe-device-extra.pri << EOF
    QMAKE_LIBS_EGL += -lEGL
    QMAKE_LIBS_OPENGL_ES2 += -lGLESv2 -lEGL

    DISTRO_OPTS += hard-float
    DISTRO_OPTS += deb-multi-arch

    # Preferred eglfs backend
    EGLFS_DEVICE_INTEGRATION = eglfs_kms
    QT_QPA_DEFAULT_PLATFORM = eglfs
EOF
}