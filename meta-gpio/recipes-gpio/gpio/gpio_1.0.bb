#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/cu-ecen-5013/final-project-swatikadivar.git;protocol=http"
PV = "1.0+git${SRCPV}"
SRCREV = "590900f209fe18d460e955d3a281051087f6a2aa"

#FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

S = "${WORKDIR}/git"

#inherit autotools

FILES_${PN} += "${bindir}/gpio"
# TODO: customize these as necessary for any libraries you need for your application
TARGET_LDFLAGS += "-pthread -lrt"
#inherit update-rc.d
#INITSCRIPT_PACKAGES= "${PN}"
#INITSCRIPT_NAME_${PN}="socketserver-start-stop"


do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${S}/gpio ${D}${bindir}/	
#	install -d ${D}${sysconfdir}/init.d
#	install -m 0755 ${S}/socketserver-start-stop ${D}${sysconfdir}/init.d


	# TODO: Install your binaries/scripts here.
	# Be sure to install the target directory with install -d first
	# Yocto variables ${D} and ${S} are useful here, which you can read about at 
	# https://www.yoctoproject.org/docs/latest/ref-manual/ref-manual.html#var-D
	# and
	# https://www.yoctoproject.org/docs/latest/ref-manual/ref-manual.html#var-S
	# See example at https://github.com/cu-ecen-5013/ecen5013-yocto/blob/ecen5013-hello-world/meta-ecen5013/recipes-ecen5013/ecen5013-hello-world/ecen5013-hello-world_git.bb

}

# The autotools configuration I am basing this on seems to have a problem with a race condition when parallel make is enabled
PARALLEL_MAKE = ""
