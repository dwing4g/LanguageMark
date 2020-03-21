@echo off
setlocal
pushd %~dp0

echo queen.c - non-recursion
x86_64-w64-mingw32-gcc -m64 -Ofast queen.c -o queen_gcc.exe -static
ping 127.1 -n 2 >nul
queen_gcc.exe

echo queen.rs - non-recursion
rustc -O -C opt-level=3 queen.rs -o queen_rust.exe
ping 127.1 -n 2 >nul
queen_rust.exe

echo queen_a.rs - non-recursion
rustc -O -C opt-level=3 queen_a.rs -o queen_a_rust.exe
ping 127.1 -n 2 >nul
queen_a_rust.exe

echo queen.go - non-recursion
go build -o queen_go.exe queen.go
ping 127.1 -n 2 >nul
queen_go.exe

echo queen.java - non-recursion
javac queen.java
ping 127.1 -n 2 >nul
java queen

echo queen2.c - recursion
x86_64-w64-mingw32-gcc -m64 -Ofast queen2.c -o queen2_gcc.exe -static
ping 127.1 -n 2 >nul
queen2_gcc.exe

echo queen2.rs - recursion
rustc -O -C opt-level=3 queen2.rs -o queen2_rust.exe
ping 127.1 -n 2 >nul
queen2_rust.exe

echo queen2_a.rs - recursion
rustc -O -C opt-level=3 queen2_a.rs -o queen2_a_rust.exe
ping 127.1 -n 2 >nul
queen2_a_rust.exe

echo queen2.java - recursion
javac queen2.java
ping 127.1 -n 2 >nul
java queen2
