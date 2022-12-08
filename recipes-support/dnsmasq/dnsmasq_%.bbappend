# dnsmasq settings for pi zero router
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
do_install:append () {
    install -d ${D}${sysconfdir}
    install -m 644 ${WORKDIR}/dnsmasq.conf ${D}${sysconfdir}/dnsmasq.conf
}