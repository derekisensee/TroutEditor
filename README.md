A Trout-themed Text Editor.

Java 8 is required.

##Build Instructions
If you're on Linux, you can simply `git clone https://github.com/falldj/TroutEditor.git` the repository, `cd src/` into the src folder, and run the `./buildJar.sh` script. This will automatically create a .jar for your use, with the latest code revisions.

To update, update the repository with `git pull`, then run the buildJar.sh again.

If you're on Windows, you can `javac *.java` in the src/ folder, then (from the root folder, TroutEditor/) you can run `java src.Driver`. 

Or, you can create a .jar. Make sure you're in the src/ folder, and compile all of the .java files with `javac *.java`. Then, while still in the src/ folder, run `jar cvf TroutEditor.jar Driver.class`. In theory, this should work, but it's being weird on my Windows 10 install.  
