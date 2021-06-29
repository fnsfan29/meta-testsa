IMAGE_INSTALL_append = " helloworld sl pacman4console"

sa_html_out(){
	#@HACK http://localhost:8080/sa/result.html
	sudo rm -rf /var/www/html/sa
	sudo mkdir -p /var/www/html/sa
	sudo cp -a ${DEPLOY_DIR_IMAGE}/sa/html/* /var/www/html/sa
}
IMAGE_POSTPROCESS_COMMAND += "sa_html_out; "
