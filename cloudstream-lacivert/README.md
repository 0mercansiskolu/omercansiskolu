# Lacivert Sports Cloudstream

Bu klasör, Lacivert Sports için Cloudstream eklenti iskeletini içerir.

## Dosyalar

- `LacivertSports/build.gradle.kts`: Cloudstream eklenti meta bilgileri
- `LacivertSports/src/main/kotlin/LacivertSportsPlugin.kt`: eklenti giriş noktası
- `LacivertSports/src/main/kotlin/LacivertSportsProvider.kt`: canlı yayın provider iskeleti

## Not

Bu iskelet yayın kaynağı olarak yalnızca izinli/kendi kaynaklarının eklenmesi için hazırlanmıştır. Ücretli veya telifli üçüncü taraf yayınların erişim kontrollerini aşan kaynak çıkarma kodu içermez.

Cloudstream'ın resmi TestPlugin şablonunda bu `LacivertSports` modülünü kullanarak derleme yapılabilir. Resmi dokümana göre GitHub Actions için `Settings > Actions > General` altında Actions açık olmalı ve workflow izinleri `Read and write permissions` olarak ayarlanmalıdır.
