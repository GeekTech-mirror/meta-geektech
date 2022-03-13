SUMMARY = "Qt6 Cybercraft Application"
DESCRIPTION = "The Cybercraft software is a educational course designed \
to teach students about different cyber attacks and the importance of \
online security. The software is designed with a 800x480 display in mind \
the program may run on other displays but is not tested."
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464"

DEPENDS = "qtbase"
RDEPENDS:${PN} = "qtsvg packagegroup-fonts-truetype"

SRC_URI = "git://github.com/GeekTech-mirror/qt-cybercraft.git;branch=main;protocol=https"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git/QT_Application"

inherit qt6-cmake

inherit archiver
ARCHIVER_MODE[src] = "original"