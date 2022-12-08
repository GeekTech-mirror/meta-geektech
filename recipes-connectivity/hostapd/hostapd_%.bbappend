FILESEXTRAPATHS:prepend := "${THISDIR}/conf:"

SRC_URI += "file://hostapd.conf"

do_install:append() {
    install -m 0644 ${WORKDIR}/hostapd.conf ${D}${sysconfdir}
}

SYSTEMD_AUTO_ENABLE:${PN} = "enable"
