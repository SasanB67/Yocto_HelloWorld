SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://salam.c"

S = "${WORKDIR}/example"

do_unpack() {
    mkdir -p ${WORKDIR}/example
    cp ${THISDIR}/files/salam.c ${WORKDIR}/example/
}

do_compile() {
    echo "WORKDIR contents:"
    ls ${WORKDIR}
    echo "S contents:" 
    ls ${S}
    
    if [ -f ${S}/salam.c ]; then
        ${CC} ${CFLAGS} ${LDFLAGS} -o salam salam.c
    else
        echo "Error: ${S}/salam not found"
        exit 1
    fi
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 salam ${D}${bindir}
}
