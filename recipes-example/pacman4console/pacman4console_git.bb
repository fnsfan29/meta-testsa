DESCRIPTION = "Pacman for console is a console based PacMan"
SECTION = "games"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/COPYING;md5=751419260aa954499f7abaabaa882bbe"

PV  = "1.2-git${SRCPV}"
SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/YoctoForBeaglebone/pacman4console.git;branch=master\
			file://makefile.patch"

S = "${WORKDIR}/git"

DEPENDS = "ncurses"

inherit sa

do_install () {
	oe_runmake DESTDIR="${D}" install
}

FILES_${PN} += " \
  /usr/local/share \
  /usr/local/share/pacman \
  /usr/local/share/pacman/Levels \
  /usr/local/share/pacman/Levels/level02.dat \
  /usr/local/share/pacman/Levels/level09.dat \
  /usr/local/share/pacman/Levels/README \
  /usr/local/share/pacman/Levels/level05.dat \
  /usr/local/share/pacman/Levels/level08.dat \
  /usr/local/share/pacman/Levels/level04.dat \
  /usr/local/share/pacman/Levels/level07.dat \
  /usr/local/share/pacman/Levels/template.dat \
  /usr/local/share/pacman/Levels/level03.dat \
  /usr/local/share/pacman/Levels/level01.dat \
  /usr/local/share/pacman/Levels/level06.dat \
  /usr/local/bin/pacman \
  /usr/local/bin/pacmanedit \
"
