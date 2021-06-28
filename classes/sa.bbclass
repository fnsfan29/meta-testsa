#addtask do_static_analysis before do_compile
addtask do_static_analysis after do_unpack do_prepare_recipe_sysroot
do_static_analysis() {
	mkdir -p ${DEPLOY_DIR_IMAGE}/sa
	#/usr/bin/splint ${S}/hello.c +htmlfileformat > ${DEPLOY_DIR_IMAGE}/sa/result.html || :
	/usr/bin/cppcheck ${S} --std=c11 --language=c --inline-suppr -v --enable=all --inconclusive --xml --output-file=${DEPLOY_DIR_IMAGE}/sa/${PN}-cppcheck.xml --suppress=missingIncludeSystem -D__x86_64__
	/usr/bin/cppcheck-htmlreport --file=${DEPLOY_DIR_IMAGE}/sa/${PN}-cppcheck.xml --title=iutest --report-dir=${DEPLOY_DIR_IMAGE}/sa/html-${PN}
	#@HACK http://localhost:8080/sa/result.html
	sudo cp -a ${DEPLOY_DIR_IMAGE}/sa /var/www/html
}
EXPORT_FUNCTIONS do_static_analysis
