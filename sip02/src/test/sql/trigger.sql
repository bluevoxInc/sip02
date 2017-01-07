CREATE OR REPLACE FUNCTION update_date_modified_column() 
	RETURNS trigger AS $update_date_modified_column$
	BEGIN
  		NEW.date_modified := now();
  		RETURN NEW;
  	END;
$update_date_modified_column$ LANGUAGE plpgsql;


CREATE TRIGGER update_date_modified_column
  BEFORE UPDATE ON contact
  FOR EACH ROW
  EXECUTE PROCEDURE update_date_modified_column();