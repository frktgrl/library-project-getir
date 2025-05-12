# 📚 Library Management System – Getir Java Spring Boot Bootcamp

Bu proje, kütüphane yönetimini dijitalleştirmek amacıyla geliştirilmiş bir Spring Boot uygulamasıdır. Kütüphaneciler kitapları, kullanıcıları ve ödünç alma işlemlerini kolayca yönetebilir.

---

## 🔧 Kullanılan Teknolojiler
- Java 21
- Spring Boot 3
- Spring Security + JWT
- Spring Data JPA (Hibernate)
- PostgreSQL (H2 for tests)
- Swagger / OpenAPI
- JUnit 5 / Mockito
- Docker & Docker Compose
- Maven

---

## 🚀 Projeyi Çalıştırma

### PostgreSQL Gerekli Ayarlar
```
DB adı: librarydb
Kullanıcı: postgres
Şifre: yourpassword
```

### Maven ile çalıştırmak için:
```bash
mvn clean install
mvn spring-boot:run
```


## 📘 API Dokümantasyonu
Uygulama çalıştıktan sonra Swagger arayüzüne aşağıdaki URL üzerinden erişebilirsin:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 📮 Postman API Koleksiyonu
Koleksiyon dosyası: `library_postman_collection.json`  
Kapsadığı istekler:
- Kullanıcı girişi
- Kitap ekleme
- Kitap ödünç alma

---

## 🧪 Testler
Aşağıdaki birim test sınıfları mevcuttur:
- `BookServiceImplTest`
- `BookServiceTest`

Testlerde Mockito kullanılmıştır. H2 veritabanı ile çalışır.

---

## ⚙️ Ek Özellikler

- Global Exception Handling (`GlobalExceptionHandler`)
- Logger kullanımı (`LoggerFactory`)
- Role-based yetkilendirme (`@PreAuthorize`)
- Overdue kitap listesi için özel endpoint (`/borrow/overdue`)

- ---

## 📁 Proje Yapısı
- `controller`: API uç noktaları
- `service`: İş mantığı
- `repository`: JPA veri erişim katmanı
- `dto`: Veri transfer nesneleri
- `config`: Güvenlik ve Swagger yapılandırması
- `exception`: Global hata yönetimi
  
![proje çalışıyor](https://github.com/user-attachments/assets/887717b0-ab43-4732-9fa8-e26ba1da1d0d)

![swagger görüntüleri ](https://github.com/user-attachments/assets/c513c1b9-ade9-4a54-903f-7157095170bb)



