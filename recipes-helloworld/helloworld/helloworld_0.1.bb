SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "MIT"

PR = "r0"
LIC_FILES_CHKSUM = "file://hello.c;md5=b8fbcf5fbb919cbe71d870aa0dca7c3b"
SRC_URI = "file://hello.c"

inherit sa

S = "${WORKDIR}"

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} -o hello hello.c
}

do_install() {
	install -d ${D}${bindir}/
	install -m 0755 ${S}/hello ${D}${bindir}/
}

FILES_${PN} = "${bindir}/hello"

