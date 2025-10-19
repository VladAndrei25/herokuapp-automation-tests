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

---

## 🧩 Project Structure
automation/
├── pom.xml
├── src/
│ ├── main/java/org/example/Main.java
│ └── test/java/tests/
│ ├── AddRemoveElementsTest.java
│ ├── CheckBoxesTest.java
│ ├── DragAndDropTest.java
│ ├── DropDownTest.java
│ ├── FormAuthenticationTest.java
│ ├── HoverTest.java
│ ├── InputsTest.java
│ ├── KeyPressesTest.java
│ ├── RightClickContextTest.java
│ └── ...
└── .mvn/

---

## ▶️ How to Run Tests

**Run from IntelliJ IDEA**
- Right-click on a test class → **Run 'ClassName'**

**Run from terminal**
'''bash
mvn clean test

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
- Right Click Context Menuv [https://the-internet.herokuapp.com/context_menu]

## 🧾 License
Distributed under the MIT License

## 👤 Author
Radulescu Vlad Andrei
📧 GitHub Profile: [https://github.com/VladAndrei25]
💬 Feel free to reach out for collaboration or feedback!
