CREATE TABLE IF NOT EXISTS LOCATION_CAPTURE (
    id                                  CHARACTER VARYING(64),
    clientReferenceId                   CHARACTER VARYING(64),
    tenantId                            CHARACTER VARYING(1000),
    latitude                            DOUBLE PRECISION,
    longitude                           DOUBLE PRECISION,
    locationAccuracy                    INTEGER,
    createdBy                           CHARACTER VARYING(64),
    createdTime                         BIGINT,
    lastModifiedBy                      CHARACTER VARYING(64),
    lastModifiedTime                    BIGINT,
    clientCreatedTime                   BIGINT,
    clientLastModifiedTime              BIGINT,
    clientCreatedBy                     CHARACTER VARYING(64),
    clientLastModifiedBy                CHARACTER VARYING(64),
    action                              CHARACTER VARYING(256),
    CONSTRAINT pk_location_capture PRIMARY KEY (id)
);

CREATE INDEX IF NOT EXISTS idx_location_capture_clientCreatedBy ON LOCATION_CAPTURE (clientCreatedBy);
