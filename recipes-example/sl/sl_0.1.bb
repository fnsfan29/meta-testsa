SUMMARY = "SL(1): Cure your bad habit of mistyping"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=74e9dd589a0ab212a9002b15ef2b82f0"

SRCREV = "923e7d7ebc5c1f009755bdeb789ac25658ccce03" 
SRC_URI = "git://github.com/mtoyoda/sl.git \
           file://0001-for-yocto.patch \
           "

S = "${WORKDIR}/git"

inherit sa

do_install() {
             install -d ${D}${bindir}
             install -m 0755 sl ${D}${bindir}
}

DEPENDS = "ncurses"
