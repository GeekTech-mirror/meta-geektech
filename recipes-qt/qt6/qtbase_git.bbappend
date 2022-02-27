PACKAGECONFIG += "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', ' kms', '', d)}"

PACKAGECONFIG += " \
    cups \
    glib \
    gles2 \
    sql-sqlite \
    tslib \
    xkbcommon \
    "

do_configure:prepend() {
    cat > ${S}/mkspecs/oe-device-extra.pri << EOF

    QMAKE_LIBS_EGL         += -lEGL
    QMAKE_LIBS_OPENGL_ES2  += -lGLESv2 -lEGL

    QMAKE_CFLAGS            = -lEGL -ldl -lglib-2.0 -lpthread
    QMAKE_CXXFLAGS          = $$QMAKE_CFLAGS -lGLESv2 -lgsl

    EGLFS_DEVICE_INTEGRATION = eglfs_kms

    QT_QPA_DEFAULT_PLATFORM = eglfs
EOF
}
