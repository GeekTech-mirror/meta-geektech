do_deploy:append() {
    # Miuzei 800x480 4\" IPS capacitive touch screen (http://www.lcdwiki.com/res/MPI4008/MPI4008-4inch-HDMI-Display-C-User-Manual-V1.0.pdf)
    if [ "${MPI4008}" = "1" ]; then
        echo "# Miuzei 800x480 4\" IPS capacitive touch screen" >> $CONFIG
        echo "max_usb_current=1" >> $CONFIG
        echo "max_framebuffers=2" >> $CONFIG
        echo "# Enable SPI bus" >> $CONFIG
        echo "dtparam=spi=on" >> $CONFIG
        echo "# Enable I2C" >> $CONFIG
        echo "dtparam=i2c1=on" >> $CONFIG
        echo "dtparam=i2c_arm=on" >> $CONFIG
        echo "# Enable UART" >> $CONFIG
        echo "enable_uart=1" >> $CONFIG
        echo "disable_overscan=1" >> $CONFIG
        echo "hdmi_group=2" >> $CONFIG
        echo "hdmi_mode=87" >> $CONFIG
        echo "hdmi_cvt=480 800 60 6 0 0 0" >> $CONFIG
        echo "hdmi_force_hotplug=1" >> $CONFIG
        echo "config_hdmi_boost=4" >> $CONFIG
        echo "display_auto_detect" >> $CONFIG
        echo "dtoverlay=ads7846,cs=1,penirq=25,penirq_pull=2,speed=50000,keep_vref_on=0 swapxy=0,pmax=255,xohms=150,xmin=200,xmax=3900,ymin=200,ymax=3900" >> $CONFIG
    fi
} 
