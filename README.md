Minecraft Particle Fixer 1.4.7 (No more boom)
What is this
I play Minecraft 1.4.7 because it is the best version, but the particles make the game crash. The screen goes black and the console says a lot of things I don't want to read. So I made this patch to stop the crash.

How it works
I am using ASM. It is like a hack for the Java code.

The target: I look for the class called azr. That class is the one that hates my computer.

The fix: I put a try-catch block around the render method.

The logic: If the particle has an error, the code says "I don't care" and the game keeps running. It is simple but it works.

Folder structure
src: My .java files with the logic.

resources: The MANIFEST.MF so Forge knows I am the boss.

LICENSE: Read it. Basically, if your PC dies, don't call me.

How to install
Take the .jar file.

Put it in the coremods folder.

Start the game and pray.

If it works, you are welcome.

Disclaimer
I am a software student. I don't know everything, I just know how to fix this specific problem. Use it at your own risk, homey.

Made with pure logic and a lot of luck.