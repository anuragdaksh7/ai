## Machine Learning Algorithms Used

### 1. Linear Regression Algorithm

**Overview:**  
Linear Regression is a **supervised learning algorithm** used to predict continuous numerical values. It assumes a **linear relationship** between input features and the output variable.

**Working Principle:**
- Models the target variable \( y \) as a linear combination of input features:
  \[
  y = w_1x_1 + w_2x_2 + \dots + w_nx_n + b
  \]
- Learns parameters \( w \) (weights) and \( b \) (bias) by minimizing **Mean Squared Error (MSE)**.
- Optimization is typically done using **Ordinary Least Squares** or **Gradient Descent**.

**Advantages:**
- Simple and interpretable.
- Fast training and prediction.
- Works well when a linear relationship exists between inputs and target.

---

### 2. SVM (Support Vector Machine) Classification Algorithm

**Overview:**  
SVM is a **supervised classification algorithm** that finds the optimal boundary (hyperplane) to separate different classes with the **maximum margin**.

**Working Principle:**
- Identifies the hyperplane that maximizes the distance (margin) between the nearest data points of different classes (support vectors).
- Supports **kernel functions** to handle non-linear data by projecting it into higher dimensions.
- Solves a convex optimization problem to identify the optimal separating hyperplane.

**Advantages:**
- Effective in high-dimensional spaces.
- Works well with both linear and non-linear boundaries.
- Robust to overfitting (especially with regularization).

---

### 3. Bayesian Classifier (Naive Bayes)

**Overview:**  
Naive Bayes is a **probabilistic classifier** based on **Bayes’ Theorem**, with the assumption that all features are conditionally independent given the class label.

**Working Principle:**
- Computes the **posterior probability** for each class using:
  \[
  P(C|X) = \frac{P(X|C) \cdot P(C)}{P(X)}
  \]
- Assumes independence between features to simplify computation.
- Predicts the class with the **highest posterior probability**.

**Advantages:**
- Very fast and scalable.
- Performs well with small datasets and categorical/text data.
- Works even when feature independence is only moderately violated.

---

