LINUX_VERSION ?= "5.15.25"
LINUX_RPI_BRANCH ?= "rpi-5.15.y"
LINUX_RPI_KMETA_BRANCH ?= "yocto-5.15"

SRCREV_machine = "${AUTOREV}"
SRCREV_meta = "${AUTOREV}"

KMETA = "kernel-meta"

#KBUILD_DEFCONFIG_raspberrypi4 = "file://defconfig"
#KBUILD_DEFCONFIG_raspberrypi4-64 = "file://defconfig"

SRC_URI = " \
    git://github.com/raspberrypi/linux.git;name=machine;branch=${LINUX_RPI_BRANCH};protocol=https \
    git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${LINUX_RPI_KMETA_BRANCH};destsuffix=${KMETA} \
"

require recipes-kernel/linux/linux-raspberrypi.inc

KERNEL_DTC_FLAGS += "-@ -H epapr"