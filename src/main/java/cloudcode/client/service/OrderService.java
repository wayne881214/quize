package cloudcode.client.service;

import cloudcode.client.database.Sql2oDbHandler;
import cloudcode.client.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;


/**
 * 註解起來就好了啦.
 *
 *
 *
 *
 *
 *
 */

@Service
public class OrderService {
  /**
   * 註解起來就好了啦.
   *
   *
   *
   *
   *
   *
   */
  @Autowired
  private Sql2oDbHandler sql2oDbHandler;

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *@return tag
   *
   */
  public List<Order> getOrder() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select 商品ID productId, 買家Email buyerEmail, 商品數量 count"
          + " from 訂單資料 ";
      System.out.println(query);
      return connection.createQuery(query).executeAndFetch(Order.class);
    }
  }

  /**
   * 註解起來就好了啦.
   *
   *@param email ...
   *
   *@return tag
   *
   */
  public List<FullOrder> getFullOrder(final String email) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select 訂單ID orderID, 商品名稱 productName, 會員名稱 name, "
          + "手機號碼 phone, 寄送地址 address,商品資料.商品ID productId,"
          + "買家Email buyerEmail,商品價格 price,商品數量 count,商品圖片 imageUrl"
          + " \nfrom 訂單資料,商品資料,帳密資料,會員資料"
          + " where 訂單資料.商品ID = 商品資料.商品ID\n"
          + "and \n"
          + "  訂單資料.買家Email = 帳密資料.電子郵件\n"
          + "and\n"
          + "  帳密資料.電子郵件 = 會員資料.電子郵件\n"
          + "and\n"
          + "  帳密資料.電子郵件 ='" + email + "';";
      System.out.println(query);
      return connection.createQuery(query).executeAndFetch(FullOrder.class);
    }
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param email ...
   *@param state ...
   *@return tag
   *
   */

  public List<FullOrder> getFullOrder(final String email, final String state) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select 訂單ID orderID, 商品名稱 productName, 會員名稱 name, "
              + "手機號碼 phone, 寄送地址 address,商品資料.商品ID productId,"
              + "買家Email buyerEmail,"
              + "商品價格 price,商品數量 count,商品圖片 imageUrl"
              + " \nfrom 訂單資料,商品資料,帳密資料,會員資料"
              + " where 訂單資料.商品ID = 商品資料.商品ID\n"
              + "and \n"
              + "  訂單資料.買家Email = 帳密資料.電子郵件\n"
              + "and\n"
              + "  帳密資料.電子郵件 = 會員資料.電子郵件\n"
              + "and\n"
              + "  訂單資料.訂單狀態 = '" + state + "'\n"
              + "and\n"
              + "  帳密資料.電子郵件 ='" + email + "';";
      System.out.println(query);
      return connection.createQuery(query).executeAndFetch(FullOrder.class);
    }
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *@return tag
   *
   */
  public List<FullOrder> getFullOrder() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select 訂單ID orderID, 商品名稱 productName, 會員名稱 name, "
          + "手機號碼 phone, 寄送地址 address,"
          + "商品資料.商品ID productId,買家Email buyerEmail,"
          + "商品數量 count,商品分類 classification"
          + " \nfrom 訂單資料,商品資料,帳密資料,會員資料"
          + " where 訂單資料.商品ID = 商品資料.商品ID\n"
          + "and \n"
          + "  訂單資料.買家Email = 帳密資料.電子郵件\n"
          + "and\n"
          + "  帳密資料.電子郵件 = 會員資料.電子郵件";
      System.out.println(query);
      return connection.createQuery(query).executeAndFetch(FullOrder.class);
    }
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param state ...
   *@return tag
   *
   */
  public List<FullOrder> getFullOrderStates(final String state) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select 訂單ID orderID, 商品名稱 productName, "
          + "會員名稱 name, 手機號碼 phone, "
          + "寄送地址 address,商品資料.商品ID productId,買家Email buyerEmail,"
          + "商品價格 price,商品數量 count,商品圖片 imageUrl"
          + " \nfrom 訂單資料,商品資料,帳密資料,會員資料"
          + " where 訂單資料.商品ID = 商品資料.商品ID\n"
          + "and \n"
          + "  訂單資料.買家Email = 帳密資料.電子郵件\n"
          + "and\n"
          + "  帳密資料.電子郵件 = 會員資料.電子郵件\n"
          + "and\n"
          + "  訂單資料.訂單狀態 ='" + state + "';";
      System.out.println(query);
      return connection.createQuery(query).executeAndFetch(FullOrder.class);
    }
  }



  /**
   * 註解起來就好了啦.
   *
   *
   *@param order ...
   *@return tag
   *
   */
  public String addOrder(final Order order) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("INSERT INTO `fcu_shop`.`訂單資料` (`商品ID`, "
          + "`買家Email` ,`商品數量`,`訂單狀態`,`帳單ID`) "
          + "VALUES ('%d','%s','%d','%s','%d');", order.getproductId(),
          order.getbuyerEmail(), order.getcount(),
          order.getState(), order.getBillId());
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();
      returnMessage = query + "寫入成功";

    } catch (Exception ex) {
      // 除了SQLException以外之錯誤
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }
  /**
   * 註解起來就好了啦.
   *
   *
   *@param Email ...
   *@return tag
   *
   */

  public List<BuyerOrder> getBuyerOrder(final String Email) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("SELECT 電子郵件 buyerEmail,訂單ID orderID,商品數量 "
          + "count,商品名稱 name, 商品價格 price, 商品敘述 description"
          + " FROM (帳密資料 INNER JOIN 訂單資料 ON 訂單資料.買家EMAIL=帳密資料.電子郵件) "
          + "INNER JOIN 商品資料 ON 訂單資料.商品ID=商品資料.商品ID"
          + " where 帳密資料.電子郵件='%s';", Email);
      System.out.println(query);
      return connection.createQuery(query).executeAndFetch(BuyerOrder.class);
    }
  }
  /**
   * 註解起來就好了啦.
   *
   *
   *@param Email ...
   *@return tag
   *
   */

  public List<BuyerOrder> getProductOrder(final String Email) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("SELECT 電子郵件 buyerEmail,訂單ID orderID,"
          + "商品數量 count,"
          + "商品名稱 name, 商品價格 price, 商品敘述 description"
          + " FROM (帳密資料 INNER JOIN 訂單資料 ON 訂單資料.買家EMAIL=帳密資料.電子郵件) "
          + "INNER JOIN 商品資料 ON 訂單資料.商品ID=商品資料.商品ID"
          + " where 帳密資料.電子郵件='%s';", Email);
      System.out.println(query);
      return connection.createQuery(query).executeAndFetch(BuyerOrder.class);
    }
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param productId ...
   *@return tag
   *
   */

  public List<BuyerOrder> getSellerOrder(final String productId) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("SELECT 商品名稱 name,電子郵件 buyerEmail,"
          + "訂單ID orderID,"
          + "商品數量 count, 商品價格 price, 商品敘述 description"
          + " FROM (帳密資料 INNER JOIN 訂單資料 ON 訂單資料.買家EMAIL=帳密資料.電子郵件) "
          + "INNER JOIN 商品資料 ON 訂單資料.商品ID=商品資料.商品ID "
          + " where 訂單資料.商品ID='%s';", productId);
      System.out.println(query);
      return connection.createQuery(query).executeAndFetch(BuyerOrder.class);
    }
  }

  /**
   * 註解起來就好了啦.
   *
   *@param id ...
   *@param state ...
   *@param bill ...
   *
   *@return tag
   *
   */

  public String updateOrder(final int id, final String state, final int bill) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("UPDATE `fcu_shop`.`訂單資料` SET `訂單狀態` = '%s',"
              + "`帳單ID` = '%d' WHERE (`訂單ID` = '%d');\n", state, bill, id);
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();
      returnMessage = query + "寫入成功";
    } catch (Exception ex) {
      // 除了SQLException以外之錯誤
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }

  /**
   * 註解起來就好了啦.
   *
   *@param order ...
   *@return tag
   *
   *
   */

  public String updateOrder(final Order order) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("UPDATE `fcu_shop`.`訂單資料` SET `商品數量` = '%d' "
              + "WHERE (`訂單ID` = '%d');",
              order.getcount(), order.getproductId());
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();

      returnMessage = query + "寫入成功";

    } catch (Exception ex) {
      // 除了SQLException以外之錯誤
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *@return tag
   *
   */

  public Object getMaxBill() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "SELECT max(帳單ID)" + " FROM `fcu_shop`.`訂單資料`;";
      return connection.createQuery(query).executeScalar();
    }
  }

  /**
   * 註解起來就好了啦.
   *
   *@param email ...
   *@param productId ...
   *@return tag
   *
   */

  public Object getReCount(final String email, final int productId) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("SELECT count('訂單ID')  "
             + "FROM 訂單資料 where 買家Email='%s' "
             + "and 商品ID=%d and 訂單狀態='下單中';", email, productId);
      return connection.createQuery(query).executeScalar();
    }
  }


  /**
   * 註解起來就好了啦.
   *
   *@param state ...
   *@param billId ...
   *@return tag
   *
   */

  public String updateBill(final String state, final int billId) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      connection.createQuery("SET SQL_SAFE_UPDATES=0;\n",
              true).executeUpdate().getKey();
      String query = String.format("UPDATE fcu_shop.訂單資料 \n"
          + "SET 訂單狀態 = '%S'\n"
          + "where 帳單ID='%d';", state, billId);
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();
      connection.createQuery("SET SQL_SAFE_UPDATES=1;\n",
              true).executeUpdate().getKey();
      returnMessage = query + "寫入成功";
    } catch (Exception ex) {
      // 除了SQLException以外之錯誤
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param ID ...
   *@return tag
   *
   */

  public String deleteOrder(final int ID) {
    //刪除特定訂單
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("DELETE FROM `fcu_shop`.`訂單資料` "
              + "WHERE (`訂單ID` = '%d');", ID);
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();
      returnMessage = query + "寫入成功";
    } catch (Exception ex) {
      // 除了SQLException以外之錯誤
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }
  /**
   * 註解起來就好了啦.
   *
   *
   *@param email ...
   *@return tag
   *
   */

  public List<Integer> getBillId(final String email) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("SELECT  DISTINCT 帳單ID\n"
          + "FROM fcu_shop.訂單資料\n"
          + "where 買家Email='%s'\n"
          + "order by 帳單ID;", email);
      System.out.println(query);
      return connection.createQuery(query).executeAndFetch(Integer.class);
    }
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param billId ...
   *@return tag
   *
   */

  public List<Bill> getBill(final int billId) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("SELECT 商品圖片 imageUrl,商品名稱 "
          + "name,商品數量 count,商品價格 price,"
          + "商品分類 classification,(商品數量*商品價格) as sum,訂單狀態 state\n"
          + "FROM fcu_shop.訂單資料 INNER JOIN fcu_shop.商品資料 "
          + "ON fcu_shop.訂單資料.商品ID=fcu_shop.商品資料.商品ID\n"
          + "where 帳單ID='%d';", billId);
      System.out.println(query);
      return connection.createQuery(query).executeAndFetch(Bill.class);
    }
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *
   *@return tag
   *
   */

  public List<MemberBill> getAllBill() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String q = "SET sql_mode=(SELECT REPLACE("
              + "@@sql_mode,'ONLY_FULL_GROUP_BY',''));";
      connection.createQuery(q, true).executeUpdate().getKey();
      String query = "\tSELECT 帳單ID billId, 會員頭像 imageUrl,"
            + "會員名稱 name,寄送地址 address,"
            + "訂單狀態 state\n"
            + "\tFROM fcu_shop.訂單資料 inner join fcu_shop.會員資料 "
            + "on fcu_shop.會員資料.電子郵件=fcu_shop.訂單資料.買家Email\n"
            + "\tGROUP BY 帳單ID\n"
            + "\torder by 帳單ID DESC;";
      System.out.println(query);
      return connection.createQuery(query).executeAndFetch(MemberBill.class);
    }
  }

  /**
   * 註解起來就好了啦.
   *
   *
   *@param state ...
   *
   *@return tag
   */
  public List<MemberBill> getAllBill(final String state) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String q = "SET sql_mode=(SELECT REPLACE("
              + "@@sql_mode,'ONLY_FULL_GROUP_BY',''));";
      connection.createQuery(q, true).executeUpdate().getKey();
      String query = String.format("SELECT 帳單ID billId, "
          + "會員頭像 imageUrl,會員名稱 name,"
          + "寄送地址 address,\t訂單狀態 state\n"
          + "FROM fcu_shop.訂單資料 "
          + "inner join fcu_shop.會員資料 on 會員資料.電子郵件=訂單資料.買家Email\n"
          + "where 訂單狀態='%s'\n"
          + "GROUP BY 帳單ID\n"
          + "order by 帳單ID DESC;", state);
      System.out.println(query);
      return connection.createQuery(query).executeAndFetch(MemberBill.class);
    }
  }

}
