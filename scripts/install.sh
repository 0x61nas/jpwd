#!/bin/env sh

# check sudo permissions
if (( "$EUID" != 0 )); then
  echo "Please run this script with sudo"
  exit 1
fi


INSTALL_PATH=/usr/share/java/jpwd
VERSION=0.0.3

mkdir -p "$INSTALL_PATH"

echo "Install version: $VERSION"
echo "Downloading jar file..."
sudo wget "https://github.com/Anas-Elgarhy/jpwd/releases/download/$VERSION/jpwd.jar"
sudo mv ./jpwd.jar "$INSTALL_PATH"/jpwd.jar

printf "\nDownloaded in %s/jpwd.jar\n" $INSTALL_PATH

echo "Create the executable file in /bin"
# shellcheck disable=SC2024
sudo echo "exec /usr/bin/java -jar $INSTALL_PATH/jpwd.jar \$@" >>  /bin/jpwd

sudo chmod +x /bin/jpwd

printf "\nDone, enjoy :D\n"

echo "Please type jpwd --help to show the available options"
echo "If the icons do not appear or appear wrongly, please make sure that you have installed nerd font"
