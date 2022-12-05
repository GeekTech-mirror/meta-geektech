SUMMARY = "RTL8192AU kernel driver (wifi)"
DESCRIPTION = "RTL8188EUS kernel driver"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://hal/hal_com_c2h.h;md5=d1415c223f48d77507154f01e7fa002f;endline=14"

SRC_URI = "\
    git://github.com/aircrack-ng/rtl8188eus.git;protocol=https;branch=v5.3.9 \
    file://realtek.conf"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

#PV = "1.0-git"

DEPENDS = "virtual/kernel bc"

inherit module

EXTRA_OEMAKE  = "ARCH=${ARCH}"
EXTRA_OEMAKE += "KSRC=${STAGING_KERNEL_BUILDDIR}"

FILES:${PN} += " \
    /etc/modprobe.d/realtek.conf \
    ${libdir} \
"

KERNEL_MODULE_AUTOLOAD += "8188eu"

do_compile () {
    unset LDFLAGS
    oe_runmake
}

do_install () {
    install -d ${D}/etc/modprobe.d
    install -m 755 ${WORKDIR}/realtek.conf ${D}/etc/modprobe.d/realtek.conf

    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -p -m 644 ${B}/8188eu.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/8188eu.ko
}
