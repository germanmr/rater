INSERT INTO BRANDS (id, name) VALUES ( 1, 'ZARA');

INSERT INTO PRODUCTS (id, name) VALUES ( 35455, 'PRODUCTO 1');


INSERT INTO PRICES (brand_id, start_date, end_date, id, product_id, priority, price, currency) VALUES (
 1, '2020-06-14 00.00.00','2020-12-31 23.59.59', 1, 35455, 0, 35.50, 'EUR');
INSERT INTO PRICES (brand_id, start_date, end_date, id, product_id, priority, price, currency) VALUES (
 1, '2020-06-14 15.00.00','2020-06-14 18.30.00', 2, 35455, 1, 25.45, 'EUR');
 INSERT INTO PRICES (brand_id, start_date, end_date, id, product_id, priority, price, currency) VALUES (
 1, '2020-06-15 00.00.00','2020-06-15 11.00.00', 3, 35455, 1, 30.50, 'EUR');
 INSERT INTO PRICES (brand_id, start_date, end_date, id, product_id, priority, price, currency) VALUES (
 1, '2020-06-15 16.00.00','2020-12-31 23.59.59', 4, 35455, 1, 38.95, 'EUR');