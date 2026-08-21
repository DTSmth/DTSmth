# Hi, I'm David 👋

**Software engineer working on healthcare data exchange.** I build backend services in **Java & Spring Boot** for a behavioral health / IDD electronic health record platform — REST APIs, PostgreSQL data modeling, and X12 EDI claim acknowledgment processing. Outside of work I build HL7 v2 interface tooling.

Coming from an EHR operations and enterprise IT background, I care about the unglamorous half of integration: what happens when the downstream system is offline, when a payer changes their file format without telling you, and when a vendor sends a segment that isn't in the spec.

- 🔭 Currently building **[hl7-lab](https://github.com/DTSmth/hl7-lab)** — HL7 v2 parsing, mapping, and MLLP messaging in Spring Boot
- 🌱 Currently learning **FHIR R4 / US Core** and **Mirth Connect (Open Integration Engine)**
- 💬 Ask me about **HL7 v2, MLLP, Java/Spring Boot, or relational data modeling**
- 📫 Reach me on [LinkedIn](https://www.linkedin.com/in/davidtsmithdev/)

---

## 🏥 Featured — [hl7-lab](https://github.com/DTSmth/hl7-lab)

A working Spring Boot project that parses real HL7 v2 messages, converts them into clean domain objects, and sends and receives them over MLLP.

| | |
|---|---|
| **Message types** | ADT, ORU, SIU — with an extensible mapper pattern for adding more |
| **Transport** | Bidirectional MLLP — server listener and client sender |
| **Acknowledgments** | Distinguishes **AA** (accept), **AE** (application error — sender's fault), and **AR** (reject — receiver's fault), so an outage doesn't quietly become data loss |
| **Architecture** | HAPI imports confined to the `hl7` package; domain objects are plain Java records with no vendor dependency |
| **Testing** | Parsing, mapping, validation, round-trip build/encode, and MLLP socket communication |
| **Stack** | Java 21 · Spring Boot · Maven · HAPI HL7v2 · no database or external services required |

**[care-connect](https://github.com/DTSmth/care-connect)** — full-stack application matching open client shifts with available caregivers. [Live demo](https://care-rust-244230612831.us-east1.run.app/)

---

## 🛠️ Tech Stack

### 🔌 Healthcare Interoperability

![HL7 v2](https://img.shields.io/badge/HL7_v2.x-005EB8?style=for-the-badge)
![MLLP](https://img.shields.io/badge/MLLP-005EB8?style=for-the-badge)
![HAPI HL7v2](https://img.shields.io/badge/HAPI_HL7v2-005EB8?style=for-the-badge)
![X12 EDI](https://img.shields.io/badge/X12_EDI_837%2F835%2F999-0F766E?style=for-the-badge)
![HIPAA](https://img.shields.io/badge/PHI_%2F_HIPAA-0F766E?style=for-the-badge)

> **Working with:** ADT, ORU, ORM, SIU message types · segment and data-type mapping · ACK/NACK handling · EHR data structures
>
> **Currently learning:** FHIR R4 / US Core · Mirth Connect (Open Integration Engine) · LOINC & ICD-10

### 💻 Languages & Frameworks

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![TypeScript](https://img.shields.io/badge/typescript-%23007ACC.svg?style=for-the-badge&logo=typescript&logoColor=white)
![Python](https://img.shields.io/badge/python-3670A0?style=for-the-badge&logo=python&logoColor=ffdd54)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)

### 🗄️ Databases & Data Modeling

![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![SQL](https://img.shields.io/badge/SQL-lightgrey?style=for-the-badge&logo=sqlite&logoColor=black)

> **Specialized in:** schema and E/R design, query optimization, JDBC, data mapping between systems

### 🎨 Frontend

![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB)
![Vue.js](https://img.shields.io/badge/vuejs-%2335495e.svg?style=for-the-badge&logo=vuedotjs&logoColor=%234FC08D)
![Ext JS](https://img.shields.io/badge/Ext%20JS-black?style=for-the-badge&logo=sencha&logoColor=white)

### ⚙️ Tools, Testing & Methodology

![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Selenium](https://img.shields.io/badge/-selenium-%2343B02A?style=for-the-badge&logo=selenium&logoColor=white)
![Agile](https://img.shields.io/badge/Agile-blueviolet?style=for-the-badge&logo=asana&logoColor=white)

> **Testing:** JUnit, unit testing, integration testing

### ⛓️ Also in the toolbox

Rust and Solana/Anchor smart contract development — see [rust_blockchain](https://github.com/DTSmth/rust_blockchain), [transaction-decoder](https://github.com/DTSmth/transaction-decoder), and [crud-solana](https://github.com/DTSmth/crud-solana).

---

### 📜 Certifications

[![AWS Badge](https://img.shields.io/badge/AWS-Certified_Cloud_Practitioner-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white)](https://www.credly.com/badges/687c1319-2d5e-4de4-b836-7ff07da55611/public_url)
![CompTIA Project+](https://img.shields.io/badge/CompTIA-Project%2B-C8202F?style=for-the-badge)
![CompTIA A+](https://img.shields.io/badge/CompTIA-A%2B-C8202F?style=for-the-badge)
![ITIL v4](https://img.shields.io/badge/ITIL-v4_Foundations-6A1B9A?style=for-the-badge)

---

### 🤝 Connect with me

[<img src="https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white" />](https://www.linkedin.com/in/davidtsmithdev/)
