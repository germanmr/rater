
-- Indexing dates withouth "priority" field for best performance
CREATE INDEX IDX_PRICE_LIST_DATES ON prices(start_date, end_date);