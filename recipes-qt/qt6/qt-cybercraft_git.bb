SUMMARY = "Cybersecurity Lesson in Qt"
DESCRIPTION = "The Cybercraft software is a educational course designed \
to teach students about different cyber attacks and the importance of \
online security. The software is designed with a 800x480 display in mind. \
The program may run on other displays but is not tested."
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464"

DEPENDS = "qtbase networkmanager extra-cmake-modules libpcap"
RDEPENDS:${PN} = "qtsvg packagegroup-fonts-truetype networkmanager libpcap"

SRC_URI = " \
    git://github.com/GeekTech-mirror/qt-cybercraft.git;branch=dev;protocol=https \
    file://cybersecurity_lesson.service"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git/Cybersecurity_Lesson"

FILES:${PN} += " \
    /usr/share/qlogging-categories6 \
    /lib/systemd/system/cybersecurity_lesson.service \
    /usr/share/* \
    /usr/src/* \
    /usr/src/.gitignore \
"

inherit qt6-cmake

# start app on boot
inherit systemd

#SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "cybersecurity_lesson.service"

do_install:append () {
    install -d ${D}${systemd_unitdir}/system/
    install -m 644 ${WORKDIR}/cybersecurity_lesson.service ${D}${systemd_unitdir}/system
}

INHERIT += "archiver"
ARCHIVER_MODE[src] = "original"