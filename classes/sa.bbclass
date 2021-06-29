do_static_analysis() {
	sudo mkdir -p ${DEPLOY_DIR_IMAGE}/sa
	#/usr/bin/splint ${S}/hello.c +htmlfileformat > ${DEPLOY_DIR_IMAGE}/sa/result.html || :
	sudo /usr/bin/cppcheck ${S} --std=c11 --language=c --inline-suppr -v --enable=all --inconclusive --xml --output-file=${DEPLOY_DIR_IMAGE}/sa/${PN}-cppcheck.xml --suppress=missingIncludeSystem -D__x86_64__
	sudo rm -rf ${DEPLOY_DIR_IMAGE}/sa/html/${PN}
	sudo mkdir -p ${DEPLOY_DIR_IMAGE}/sa/html/${PN}
	sudo /usr/bin/cppcheck-htmlreport --file=${DEPLOY_DIR_IMAGE}/sa/${PN}-cppcheck.xml --title=iutest --report-dir=${DEPLOY_DIR_IMAGE}/sa/html/${PN}
}
addtask static_analysis after do_compile before do_package
