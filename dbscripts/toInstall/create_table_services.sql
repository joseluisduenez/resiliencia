 CREATE TABLE BNB_SERVICES (
    service_id int NOT NULL PRIMARY KEY,
 	service_name TEXT,
 	short_code int,
 	carrier_id int,
	product_id int,
	mt_free_price_point_id int,
	role_id int,
	password TEXT,
	port int,
	id_api_core int,
	mediaId int,
	serviceIdPromos int,
	serviceIdApiCOre int,
    urlPromos   TEXT,
    urlPortal   TEXT,
    pricepointId    int,
    price_point_value decimal,
    lan         TEXT,
    welcomeMessage TEXT,
    renewedMessage  TEXT,
    unsubMessage    TEXT,
    helpMessage     TEXT,
    alreadySubMessage TEXT,
    urlImageLanding TEXT
);

ALTER TABLE BNB_SERVICES ADD COLUMN pricepointIdFirstFallback int;
ALTER TABLE BNB_SERVICES ADD COLUMN pricePointValueFirstFallback decimal;
ALTER TABLE BNB_SERVICES ADD COLUMN pricepointIdSecondFallback int;
ALTER TABLE BNB_SERVICES ADD COLUMN pricePointValueSecondFallback decimal;
