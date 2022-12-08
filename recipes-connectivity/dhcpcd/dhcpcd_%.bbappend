# dhcp settings for pi zero router
do_install:append () {
    CONFIG=${D}${sysconfdir}/dhcpcd.conf
    echo "" >> $CONFIG
    echo "interface wlan0" >> $CONFIG
    echo "  static ip_address=10.1.1.1/24" >> $CONFIG
    echo "  nohook wpa_supplicant" >> $CONFIG
}