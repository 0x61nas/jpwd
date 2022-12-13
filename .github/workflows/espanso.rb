class Espanso < jpwd
  desc "jpwd: A modern alternative to GNU/pwd using Java 🥰☕"
  homepage "https://github.com/anas-elgarhy/jpwd"
  url "https://github.com/anas-elgarhy/jpwd/releases/download/0.0.3/jpwd-0.0.3-0-any.pkg.tar.zst"
  sha256 "2473866b99eef9ea983200b7aac91592b938404ffaa1fb8c72beacb2ebd3203a"
  version "0.0.3"

  def install
    bin.install "jpwd"
  end
end