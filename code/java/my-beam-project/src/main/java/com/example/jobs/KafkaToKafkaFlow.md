### ✅ **Kafka-to-Kafka Flow**  
A real-time Kafka-to-Kafka Apache Beam pipeline that filters and transforms product messages based on multiple fields.  
Only relevant products (e.g., from `ABC Corp`, in `Electronics`, active, in-stock) are pushed to the output Kafka topic after cleaning.

---

### ✅ **Input Data (to `i-topic`)**
- **Format:** JSON objects representing products
- **Fields:** 15+ fields like `productId`, `brand`, `category`, `price`, `availableStock`, `status`, etc.
- **Example:**  
  ```json
  {
    "productId": "P1234",
    "productName": "Smartphone",
    "brand": "ABC Corp",
    "category": "Electronics",
    "price": 199.99,
    "availableStock": 25,
    "status": "active"
  }
  ```

---

### ✅ **Transformations + Filters**
We apply filters:
- `brand == "ABC Corp"`
- `category == "Electronics"`
- `status == "active"`
- `availableStock > 0`

Then transform the product to include only cleaned, meaningful fields (like `productId`, `name`, `price`, `stock`, etc.).

---

### ✅ **Output Data (to `o-topic`)**
- **Format:** Filtered and trimmed JSON
- **Fields:** Fewer fields — only what’s relevant for downstream systems
- **Example:**  
  ```json
  {
    "productId": "P1234",
    "productName": "Smartphone",
    "brand": "ABC Corp",
    "category": "Electronics",
    "price": 199.99,
    "availableStock": 25
  }
  ```

---