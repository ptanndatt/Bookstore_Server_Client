
package controller;

import models.*;
import service.*;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private AuthorDaoImplService authorDaoImplService = new AuthorDaoImplService();
    private CategoryDaoImplService categoryDaoImplService = new CategoryDaoImplService();
    private ProductTypeDaoImplService productTypeDaoImplService = new ProductTypeDaoImplService();
    private SupplierDaoImplService supplierDaoImplService = new SupplierDaoImplService();
    private BookDaoImplService bookDaoImplService = new BookDaoImplService();
    private MerchandiseDaoImplService merchandiseDaoImplService = new MerchandiseDaoImplService();

    private CustomerDaoImplService customerDaoImplService = new CustomerDaoImplService();
    private EmployeeDaoImplService employeeDaoImplService = new EmployeeDaoImplService();
    private AccountDaoImplService accountDaoImplService = new AccountDaoImplService();
    private RoleDaoImplService roleDaoImplService = new RoleDaoImplService();

    //Customer
    public List<Customer> getAllCustomers() {
        return customerDaoImplService.getAllCustomers();
    }

    public boolean addCustomer(Customer customer) {
        return customerDaoImplService.addCustomer(customer);
    }

    public boolean updateCustomer(Customer customer) {
        return customerDaoImplService.updateCustomer(customer);
    }

    public boolean deleteCustomer(String id) {
        return customerDaoImplService.deleteCustomer(id);
    }

    public List<Customer> findCustomerByText(String text) {
        return customerDaoImplService.findCustomerByText(text);
    }

    //Account
    public List<Account> getAllAccount() {
        return accountDaoImplService.getAllAccount();
    }

    public boolean addAccount(Account account) {
        return accountDaoImplService.addAccount(account);
    }

    public boolean updateAccount(Account account) {
        return accountDaoImplService.updateAccount(account);
    }

    public boolean deleteAccount(String id) {
        return accountDaoImplService.deleteAccount(id);
    }

    public Account getAccountById(String id) {
        return accountDaoImplService.getAccountById(id);
    }

    public String findPasswordByEmployeeId(String employeeId) {
        return accountDaoImplService.findPasswordByEmployeeId(employeeId);
    }

    //Role
    public List<Role> getAllRole() {
        return roleDaoImplService.getAllRole();
    }

    public boolean addRole(Role role) {
        return roleDaoImplService.addRole(role);
    }

    public boolean deleteRole(String id) {
        return roleDaoImplService.deleteRole(id);
    }

    public Role findRoleByText(String text) {
        return roleDaoImplService.findRoleByText(text);
    }

    public boolean updateRole(String id) {
        return roleDaoImplService.updateRole(id);
    }

    public List<Role> getRolesByRoleCode(int roleCode) {
        return roleDaoImplService.getRolesByRoleCode(roleCode);
    }

    //Employee
    public List<Employee> getAllEmployees() {
        return employeeDaoImplService.getAllEmployees();
    }

    public boolean addEmployee(Employee employee) {
        return employeeDaoImplService.addEmployee(employee);
    }

    public boolean updateEmployee(Employee employee) {
        return employeeDaoImplService.updateEmployee(employee);
    }

    public boolean deleteEmployee(String id) {
        return employeeDaoImplService.deleteEmployee(id);
    }

    public List<Employee> findEmployeeByText(String text) {
        return employeeDaoImplService.findEmployeeByText(text);
    }

    public List<Employee> findEmployeeByRoleCode(int roleCode) {
        return employeeDaoImplService.findEmployeeByRoleCode(roleCode);
    }

    public Employee findEmployeeById(String empId) {
        return employeeDaoImplService.findEmployeeById(empId);
    }

    // author
    public List<Author> getAllAuthor() {
        return authorDaoImplService.getAllAuthor();
    }

    public boolean addAuthor(Author author) {
        return authorDaoImplService.addAuthor(author);
    }

    public boolean updateAuthor(Author author) {
        return authorDaoImplService.updateAuthor(author);
    }

    public boolean deleteAuthor(String idAuthor) {
        return authorDaoImplService.deleteAuthor(idAuthor);
    }

    public boolean checkIdAuthor(String idAuthor) {
        return authorDaoImplService.checkIdAuthor(idAuthor);
    }

    public List<Author> getLatestAuthorID() {
        return authorDaoImplService.getLatestAuthorID();
    }

    public boolean decreaseNumberOfBooks(String idAuthor) {
        return authorDaoImplService.decreaseNumberOfBooks(idAuthor);
    }

    public boolean increaseNumberOfBooks(String idAuthor) {
        return authorDaoImplService.increaseNumberOfBooks(idAuthor);
    }

    // category
    public List<Category> getAllCategory() {
        return categoryDaoImplService.getAllCategory();
    }

    public boolean addCategory(Category category) {
        return categoryDaoImplService.addCategory(category);
    }

    public boolean updateCategory(Category category) {
        return categoryDaoImplService.updateCategory(category);
    }

    public boolean deleteCategory(String idCategory) {
        return categoryDaoImplService.deleteCategory(idCategory);
    }

    public boolean checkIdCategory(String idCategory) {
        return categoryDaoImplService.checkIdCategory(idCategory);
    }

    public List<String> getLatestCategoryID() {
        return categoryDaoImplService.getLatestCategoryID();
    }

    public boolean decreaseNumberOfCategory(String idCategory) {
        return categoryDaoImplService.decreaseNumberOfCategory(idCategory);
    }

    public boolean increaseNumberOfCategory(String idCategory) {
        return categoryDaoImplService.increaseNumberOfCategory(idCategory);
    }

    // product type
    public List<ProductType> getAllProductType() {
        return productTypeDaoImplService.getAllProductType();
    }

    public ProductType getProductTypeById(String id) {
        return productTypeDaoImplService.getProductTypeById(id);
    }

    public boolean addProductType(ProductType productType) {
        return productTypeDaoImplService.addProductType(productType);
    }

    public boolean updateProductType(ProductType productType) {
        return productTypeDaoImplService.updateProductType(productType);
    }

    public boolean deleteProductType(String id) {
        return productTypeDaoImplService.deleteProductType(id);
    }

    public List<String> getLastestProductType() {
        return productTypeDaoImplService.getLastestProductType();
    }

    public boolean checkProductTypeExist(String id) {
        return productTypeDaoImplService.checkProductTypeExist(id);
    }

    // supplier
    public List<Supplier> getAllSuppliers() {
        return supplierDaoImplService.getAllSuppliers();
    }

    public boolean addSupplier(Supplier supplier) {
        return supplierDaoImplService.addSupplier(supplier);
    }

    public boolean updateSupplier(Supplier supplier) {
        return supplierDaoImplService.updateSupplier(supplier);
    }

    public boolean deleteSupplier(String id) {
        return supplierDaoImplService.deleteSupplier(id);
    }

    public boolean checkSupplierId(String id) {
        return supplierDaoImplService.checkSupplierId(id);
    }

    public List<Supplier> getLatestSupplierId() {
        return supplierDaoImplService.getLatestSupplierId();
    }

    // book
    public List<Book> getAllBook() {
        return bookDaoImplService.getAllBook();
    }

    public boolean addBook(Book book) {
        return bookDaoImplService.addBook(book);
    }

    public boolean updateBook(Book book) {
        return bookDaoImplService.updateBook(book);
    }

    public boolean deleteBook(String idBook) {
        return bookDaoImplService.deleteBook(idBook);
    }

    public boolean checkIdBook(String idBook) {
        return bookDaoImplService.checkIdBook(idBook);
    }

    public List<String> getLatestBookID() {
        return bookDaoImplService.getLatestBookID();
    }

    public List<Book> loadComboBoxByProductType(String productTypeId) {
        return bookDaoImplService.loadComboBoxByProductType(productTypeId);
    }

    public List<Book> loadComboBoxByPublisher(String publisherId) {
        return bookDaoImplService.loadComboBoxByPublisher(publisherId);
    }

    public List<Book> loadComboBoxByAuthor(String authorId) {
        return bookDaoImplService.loadComboBoxByAuthor(authorId);
    }

    public List<Book> loadComboBoxByCategory(String categoryId) {
        return bookDaoImplService.loadComboBoxByCategory(categoryId);
    }

    public List<Book> searchBook(String search) {
        return bookDaoImplService.searchBook(search);
    }


    public List<Book> findCategoryIdByName(String name) {
        return bookDaoImplService.findCategoryIdByName(name);
    }

    public List<Book> findSupplierByName(String name) {
        return bookDaoImplService.findSupplierByName(name);
    }

    public List<Book> findBookByProductType(String name) {
        return bookDaoImplService.findBookByProductType(name);
    }

    public List<Book> findBookByAuthor(String name) {
        return bookDaoImplService.findBookByAuthor(name);
    }


    // Merchandise
    public List<Merchandise> getAllMerchandise() {
        return merchandiseDaoImplService.getAllMerchandise();
    }

    public boolean addMerchandise(Merchandise merchandise) {
        return merchandiseDaoImplService.addMerchandise(merchandise);
    }

    public boolean checkIdExist(String id) {
        return merchandiseDaoImplService.checkIdExist(id);
    }

    public boolean updateMerchandise(Merchandise merchandise) {
        return merchandiseDaoImplService.updateMerchandise(merchandise);
    }

    public boolean deleteMerchandise(String id) {
        return merchandiseDaoImplService.deleteMerchandise(id);
    }

    public List<Merchandise> findBookByProductTypeMerchandise(String name) {
        return merchandiseDaoImplService.findByProductTypeMerchandise(name);
    }

    public List<Merchandise> findSupplierByNameMerchandise(String name) {
        return merchandiseDaoImplService.findSupplierByNameMerchandise(name);
    }
}
