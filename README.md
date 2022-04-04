# Yummy-QA

__Kalo mau ngerun test, bikin folder dengan nama "resources", terus taroh `app-releaseSit.apk` di dalamnya__

## Cara penggunaan:
1. Buat folder dengan nama "resources", terus taroh `app-releaseSit.apk` di dalamnya __(jika belum ada)__
2. Buat package di folder `src/main/java/Tests` jika belum ada folder untuk flow terkait
3. Buat class untuk masing-masing testcase (Template dapat diambil dari `TestBoilerPlate.java` yang ada di package Tests)
4. Jika class sudah selesai dibuat, tambahkan class tersebut ke `testng.xml` yang ada di package Tests
5. Run `testng.xml` jika ingin melakukan run seluruh test case. Kalo mau run satu-satu, dari masing-masing class testcase aja
