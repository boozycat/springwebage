 
CREATE TABLE PLAN
(
 
   PLANID     BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
   ZIP               BIGINT NOT NULL,
   NAME              VARCHAR(10) NOT NULL,
   DEDUCTABLEIND     BIGINT,
   DEDUCTABLEFAMILY  BIGINT,
   OUTOFPOCKETIND    BIGINT,
   OUTOFPOCKETFAMILY BIGINT,
   COPAY          DECIMAL(10,2),
    
   
   CONSTRAINT  PK_PLAN  PRIMARY KEY(PLANID)
);

 
