<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&height=180&section=header&text=HerokuApp%20Automation%20Tests&fontSize=40&fontAlignY=35&animation=fadeIn&fontColor=fff"/>
</p>
# 🧪 HerokuApp Automation Tests

Automated **UI testing suite** built with **Java**, **Selenium WebDriver**, **JUnit 5**, and **Maven**, targeting [the-internet.herokuapp.com](https://the-internet.herokuapp.com).  
This project is part of a personal learning effort to improve test automation skills using best practices for maintainable and scalable test design.

---

## 🧰 Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![ChromeDriver](https://img.shields.io/badge/ChromeDriver-4285F4?style=for-the-badge&logo=googlechrome&logoColor=white)

| Tool / Library | Purpose |
|----------------|----------|
| **Java 17** | Programming language |
| **Maven** | Build automation & dependency management |
| **JUnit 5** | Test framework |
| **Selenium** | Browser automation framework |
| **ChromeDriver** | WebDriver for Google Chrome |

## 🧩 Project Structure
```text
automation/
 ├── pom.xml
 ├── src/
 │   ├── main/
 │   │   ├── java/
 │   │   │   └── org/example/Main.java
 │   │   └── resources/
 │   └── test/
 │       └── java/
 │           └── tests/
 │               ├── AddRemoveElementsTest.java
 |               ├── BrokenImagesTest.java
 │               ├── CheckBoxesTest.java
 │               ├── DisappearingElementsTest.java
 │               ├── DragAndDropTest.java
 │               ├── DropDownTest.java
 │               ├── FormAuthenticationTest.java
 │               ├── HoverTest.java
 │               ├── InputsTest.java
 │               ├── KeyPressesTest.java
 │               └── RightClickContextTest.java
 └── .mvn/
```
---

## ▶️ How to Run Tests

**Run from IntelliJ IDEA**
- Right-click on a test class → **Run 'ClassName'** / **Shift+F10**

**Run from terminal**
```bash
mvn clean test
```
---

## 🧠 Included Test Cases
- Add/Remove Elements [https://the-internet.herokuapp.com/add_remove_elements/]
- BrokenImages [https://the-internet.herokuapp.com/broken_images]
- Checkboxes [https://the-internet.herokuapp.com/checkboxes] 
- Disappearing Elements [https://the-internet.herokuapp.com/disappearing_elements]
- Drag and Drop [https://the-internet.herokuapp.com/drag_and_drop]
- Dropdown Menu [https://the-internet.herokuapp.com/dropdown]
- Form Authentication [https://the-internet.herokuapp.com/login]
- Hover [https://the-internet.herokuapp.com/hovers]
- Inputs [https://the-internet.herokuapp.com/inputs]
- Key Presses [https://the-internet.herokuapp.com/key_presses] 
- Right Click Context Menu [https://the-internet.herokuapp.com/context_menu]

---

## 📸 Screenshots
Example of successful test execution in AddRemoveElements.Test:
<p align="center">
 <img width="363" height="294" alt="image" src="https://github.com/user-attachments/assets/87ca2a11-9900-4078-bf82-35c27596c61b" />
</p>
Example of succesful test execution in Inputs.Test:
<p align="center">
  <img width="363" height="294" alt="image" src="https://github.com/user-attachments/assets/3bb98fac-3dc1-4407-82f3-c688d9135032" />
</p>
 
---

## 🎥 Demo – Test Execution

<div align="center">

<img src="demoTestExecution.gif" alt="HerokuApp automation test demo" width="80%">

</div>

---

## 🧾 License
Distributed under the [MIT License](LICENSE)

---

## 👤 Author
Radulescu Vlad Andrei

📧 GitHub Profile: [https://github.com/VladAndrei25]

💬 Feel free to reach out for collaboration or feedback!

---
