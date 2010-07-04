create table ActivityLogs (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), endDate timestamp, endTime varchar2(5 char), isAllDayEvent number(1,0), notes varchar2(255 char), showInCalender number(1,0), startDate timestamp, startTime varchar2(5 char), subject varchar2(255 char), vbase2Id number(10,0), ActivityTypeId raw(16), PersonHereId raw(16), primary key (id));
create table Addresses (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), address1 varchar2(100 char), address2 varchar2(100 char), address3 varchar2(100 char), directions varchar2(2000 char), postCode varchar2(255 char), town varchar2(100 char), vbase2Id number(10,0), CountryId raw(16), CountyId raw(16), primary key (id));
create table ContactDetails (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), customEmail varchar2(255 char), customFax varchar2(255 char), customOrgName varchar2(255 char), customTelephone varchar2(255 char), customWebAddress varchar2(255 char), EmailSource varchar(30) not null, FaxSource varchar(30) not null, TelephoneSource varchar(30) not null, useCustomAddress number(1,0), useCustomOrgName number(1,0), useCustomPerson number(1,0), useVuoDetails number(1,0), WebAddressSource varchar(30) not null, AddressId raw(16), ContactId raw(16), OrganisationAddressId raw(16), OrgContactId raw(16), primary key (id));
create table Contacts (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), department varchar2(255 char), email varchar2(255 char), fax varchar2(255 char), firstName varchar2(255 char), isActive number(1,0), jobTitle varchar2(255 char), mobile varchar2(255 char), notes varchar2(255 char), preferredName varchar2(255 char), surname varchar2(255 char), tel varchar2(255 char), useAsMainContact number(1,0), usingAddressEmail number(1,0), usingAddressFax number(1,0), usingAddressTel number(1,0), vbase2Id number(10,0), TitleId raw(16), primary key (id));
create table LocationAddressLookups (LocationAddressId raw(16) not null, LookupId raw(16) not null, primary key (LocationAddressId, LookupId));
create table Locations (Discriminator varchar2(50 char) not null, id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), customOrgName varchar2(255 char), displayString varchar2(50 char), isActive number(1,0), LocationType varchar2(30 char), PublicContactDetailsSource varchar2(36 char), useCustomOrgName number(1,0), useCustomAddress number(1,0), useForContactDetails number(1,0), ContactDetailsId raw(16), OpportunityLocationId raw(16), PublicContactDetailsId raw(16), CountyId raw(16), AddressId raw(16), OrgAddressId raw(16), RegionId raw(16), primary key (id));
create table LookupTypes (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), canEdit number(1,0), isVisible number(1,0), value varchar2(255 char), primary key (id));
create table Lookups (Discriminator varchar2(50 char) not null, id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), isActive number(1,0), isUserEditable number(1,0), languageId raw(16), ownerId raw(16), sortOrder number(10,0), vBase2Id number(10,0), value varchar2(255 char), appliesToOpportunities number(1,0), appliesToOrganisations number(1,0), appliesToVolunteers number(1,0), primary key (id));
create table MetaData (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), digest blob, dtoId raw(16), serializedObject blob, type varchar2(86 char), primary key (id));
create table Opportunities (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), advertisingEndDate timestamp, advertisingStartDate timestamp, benefits varchar2(2000 char), commitmentAm number(19,0), commitmentEve number(19,0), commitmentPm number(19,0), description varchar2(2000 char), isActive number(1,0), isDateSpecific number(1,0), isOneOff number(1,0), isResidential number(1,0), isSharedInternalContactPublic number(1,0), isVirtualRemote number(1,0), locationsPubliclyViewable number(1,0), monetaryValuePerHour float, ownId varchar2(150 char), publishToDoIt number(1,0), requirements varchar2(2000 char), shortDescription varchar2(250 char), specificEndDate timestamp, specificStartDate timestamp, title varchar2(255 char), useSharedIntConDets number(1,0), useSharedPublicContactDetails number(1,0), vbase2Id number(10,0), OrganisationId raw(16), SharedInternalContactDetailsId raw(16), SharedPublicContactDetailsId raw(16), primary key (id));
create table OpportunityActLogs (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), ActivityLogId raw(16), OpportunityId raw(16), OpportunityLocationId raw(16), primary key (id));
create table OpportunityAddSpecSuitabs (OpportunityId raw(16) not null, LookupId raw(16) not null, primary key (OpportunityId, LookupId));
create table OpportunityArrPolicyEntry (OpportunityId raw(16) not null, PolicyId raw(16) not null, primary key (OpportunityId, PolicyId));
create table OpportunityCampsAndInits (OpportunityId raw(16) not null, LookupId raw(16) not null, primary key (OpportunityId, LookupId));
create table OpportunityCausesInterests (OpportunityId raw(16) not null, LookupId raw(16) not null, primary key (OpportunityId, LookupId));
create table OpportunityCommitmentTypes (OpportunityId raw(16) not null, LookupId raw(16) not null, primary key (OpportunityId, LookupId));
create table OpportunitySelectionMethods (OpportunityId raw(16) not null, LookupId raw(16) not null, primary key (OpportunityId, LookupId));
create table OpportunitySkillsRequired (OpportunityId raw(16) not null, LookupId raw(16) not null, primary key (OpportunityId, LookupId));
create table OpportunitySkillsToGain (OpportunityId raw(16) not null, LookupId raw(16) not null, primary key (OpportunityId, LookupId));
create table OpportunityTags (OpportunityId raw(16) not null, LookupId raw(16) not null, primary key (OpportunityId, LookupId));
create table OpportunityTypesOfActivity (OpportunityId raw(16) not null, LookupId raw(16) not null, primary key (OpportunityId, LookupId));
create table OrganisaitonQualityStdsAccr (OwnerId raw(16) not null, PolicyId raw(16) not null, primary key (OwnerId, PolicyId));
create table OrganisationActivityLogs (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), ActivityLogId raw(16), ContactId raw(16), OrganisationId raw(16), primary key (id));
create table OrganisationAddresses (directions varchar2(2000 char), email varchar2(255 char), emergencyTelephone varchar2(255 char), fax varchar2(255 char), friendlyName varchar2(255 char), isDefaultAddress number(1,0), organisationName varchar2(255 char), Telephone varchar2(255 char), useCustomOrganisationName number(1,0), website varchar2(255 char), AddressId raw(16) not null, OrgAddConInfoId raw(16), primary key (AddressId));
create table OrganisationCampsAndInits (OrganisationId raw(16) not null, LookupId raw(16) not null, primary key (OrganisationId, LookupId));
create table OrganisationCausesInterests (OrganisationId raw(16) not null, LookupId raw(16) not null, primary key (OrganisationId, LookupId));
create table OrganisationContacts (ContactId raw(16) not null, OrganisationId raw(16), OrganisationAddressId raw(16), primary key (ContactId));
create table OrganisationGeographicalArea (OrganisationId raw(16) not null, LookupId raw(16) not null, primary key (OrganisationId, LookupId));
create table OrganisationOrganisationType (OrganisationId raw(16) not null, LookupId raw(16) not null, primary key (OrganisationId, LookupId));
create table OrganisationPoliciesAndProc (OwnerId raw(16) not null, PolicyId raw(16) not null, primary key (OwnerId, PolicyId));
create table OrganisationTaggedData (OrganisationId raw(16) not null, LookupId raw(16) not null, primary key (OrganisationId, LookupId));
create table Organisations (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), description varchar2(2000 char), howHeardDetails varchar2(255 char), isActive number(1,0), isVuo number(1,0), missionStatement varchar2(2000 char), name varchar2(255 char) not null, openingHours varchar2(255 char), ownId varchar2(255 char), registeredCharityNumber varchar2(50 char), vbase2Id number(10,0), HowHeardId raw(16), primary key (id));
create table PolicyEntries (Discriminator varchar2(1 char) not null, id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), comments varchar2(255 char), vbase2Id number(10,0), PolicyId raw(16), PolicyStatusId raw(16), primary key (id));
create table QueriesForViews (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), hqlQuery varchar2(2000 char), queryName varchar2(255 char), sqlQuery varchar2(2000 char), vbase2Id number(10,0), primary key (id));
create table Roles (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), description varchar2(50 char), name varchar2(255 char), userId raw(16), vbase2Id number(10,0), primary key (id));
create table SearchQueries (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), data blob, isEditable number(1,0), lastUpdated timestamp, userId raw(16), primary key (id));
create table Test (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), test varchar2(255 char), primary key (id));
create table Users (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), accountLastValidated timestamp, badLogInAttempts number(10,0), firstName varchar2(50 char), fullName varchar2(100 char), isAccountExpired number(1,0), isAccountLocked number(1,0), isCredentialsExpired number(1,0), isEnabled number(1,0), lastLogInAttempt timestamp, lastName varchar2(50 char), lstLoggedIn timestamp, password varchar2(40 char) not null, passwordHint varchar2(50 char), phoneNumber varchar2(20 char), userName varchar2(50 char) not null, vbase2Id number(10,0), primary key (id));
create table UsersRoles (UserId raw(16) not null, RoleId raw(16) not null, primary key (UserId, RoleId));
create table VBase3Preference (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), applicationName varchar2(255 char), colourTheme number(10,0), copyright varchar2(255 char), dataSchemaVersion number(10,0), defaultCountryId raw(16), defaultCountyId raw(16), languageId raw(16), useDefaultCountry number(1,0), useDefaultCounty number(1,0), usingAudioNotification number(1,0), usingLogNotification number(1,0), usingVisualNotification number(1,0), primary key (id));
create table ViewsTable (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), discriminator varchar2(255 char), fieldName varchar2(255 char), isSKills number(1,0), lookupUpTypesValue varchar2(255 char), sectionLookup varchar2(255 char), sectionName varchar2(255 char), skillType varchar2(255 char), vbase2Id number(10,0), primary key (id));
create table VolunteerActivityLogs (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), ActivityLogId raw(16), VolunteerId raw(16), primary key (id));
create table VolunteerAddresses (isActive number(1,0), isDefaultAddress number(1,0), name varchar2(255 char) not null, AddressId raw(16) not null, VolunteerId raw(16), primary key (AddressId));
create table VolunteerCampInitLookups (VolunteerId raw(16) not null, LookupId raw(16) not null, primary key (VolunteerId, LookupId));
create table VolunteerCausesIntsLookups (VolunteerId raw(16) not null, LookupId raw(16) not null, primary key (VolunteerId, LookupId));
create table VolunteerCommitmentTypeLookups (VolunteerId raw(16) not null, LookupId raw(16) not null, primary key (VolunteerId, LookupId));
create table VolunteerContactEmails (email varchar2(320 char) not null, VolunteerContactInfoId raw(16) not null, VolunteerId raw(16), TelephoneTypeId raw(16), primary key (VolunteerContactInfoId));
create table VolunteerContactInfo (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), isActive number(1,0), isDefault number(1,0), notes varchar2(255 char), primary key (id));
create table VolunteerContactTelephones (tel_number varchar2(255 char) not null, VolunteerContactInfoId raw(16) not null, VolunteerId raw(16), TelephoneTypeId raw(16), primary key (VolunteerContactInfoId));
create table VolunteerCurrentSkills (VolunteerId raw(16) not null, LookupId raw(16) not null, primary key (VolunteerId, LookupId));
create table VolunteerDisabilityTypeLookups (VolunteerId raw(16) not null, LookupId raw(16) not null, primary key (VolunteerId, LookupId));
create table VolunteerGeoAreaLookups (VolunteerId raw(16) not null, LookupId raw(16) not null, primary key (VolunteerId, LookupId));
create table VolunteerReasonsMotivsLookups (VolunteerId raw(16) not null, LookupId raw(16) not null, primary key (VolunteerId, LookupId));
create table VolunteerTagsLookups (VolunteerId raw(16) not null, LookupId raw(16) not null, primary key (VolunteerId, LookupId));
create table VolunteerTypeOfActivityLookups (VolunteerId raw(16) not null, LookupId raw(16) not null, primary key (VolunteerId, LookupId));
create table VolunteerWantedSkills (VolunteerId raw(16) not null, LookupId raw(16) not null, primary key (VolunteerId, LookupId));
create table Volunteers (id raw(16) not null, created timestamp, createdBy raw(16), deleted number(1,0), modified timestamp, modifiedBy raw(16), version number(10,0), agreesToBeContacted number(1,0), amCommitment number(10,0), dateOfBirth timestamp, disabilityDetails varchar2(255 char), eveCommitment number(10,0), firstName varchar2(255 char), howHeardDetails varchar2(255 char), isActive number(1,0), lastName varchar2(255 char), otherMotivations varchar2(255 char), ownId varchar2(255 char), pmCommitment number(10,0), preferredName varchar2(255 char), qualificationsAndExperience varchar2(2000 char), vbase2Id number(10,0), AgeRangeId raw(16), AvailabilityStatusId raw(16), DisabilityStatusId raw(16), DrivingLicenceId raw(16), EmploymentStatusId raw(16), EthnicityId raw(16), GenderId raw(16), HowHeardId raw(16), NationalityId raw(16), PlacementStatusId raw(16), ReligionId raw(16), SexualOrientationId raw(16), TitleId raw(16), TransportId raw(16), primary key (id));