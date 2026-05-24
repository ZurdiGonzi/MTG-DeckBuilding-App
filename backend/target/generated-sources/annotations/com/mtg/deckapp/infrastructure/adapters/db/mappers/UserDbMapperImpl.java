package com.mtg.deckapp.infrastructure.adapters.db.mappers;

import com.mtg.deckapp.domain.model.user.User;
import com.mtg.deckapp.domain.model.user.UserType;
import com.mtg.deckapp.infrastructure.adapters.db.entities.user.UserStatus;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-24T18:03:44+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserDbMapperImpl implements UserDbMapper {

    @Override
    public User toDomain(com.mtg.deckapp.infrastructure.adapters.db.entities.user.User entity) {
        if ( entity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( entity.getId() );
        user.username( entity.getUsername() );
        user.password( entity.getPassword() );
        user.email( entity.getEmail() );
        user.description( entity.getDescription() );
        user.userType( userTypeToUserType( entity.getUserType() ) );
        user.profileImageUrl( entity.getProfileImageUrl() );
        user.active( entity.isActive() );
        user.status( userStatusToUserStatus( entity.getStatus() ) );

        return user.build();
    }

    @Override
    public com.mtg.deckapp.infrastructure.adapters.db.entities.user.User toEntity(User domain) {
        if ( domain == null ) {
            return null;
        }

        com.mtg.deckapp.infrastructure.adapters.db.entities.user.User.UserBuilder user = com.mtg.deckapp.infrastructure.adapters.db.entities.user.User.builder();

        user.id( domain.getId() );
        user.username( domain.getUsername() );
        user.password( domain.getPassword() );
        user.email( domain.getEmail() );
        user.description( domain.getDescription() );
        user.userType( userTypeToUserType1( domain.getUserType() ) );
        user.profileImageUrl( domain.getProfileImageUrl() );
        user.active( domain.isActive() );
        user.status( userStatusToUserStatus1( domain.getStatus() ) );

        return user.build();
    }

    protected UserType userTypeToUserType(com.mtg.deckapp.infrastructure.adapters.db.entities.user.UserType userType) {
        if ( userType == null ) {
            return null;
        }

        UserType userType1;

        switch ( userType ) {
            case CREATOR: userType1 = UserType.CREATOR;
            break;
            case SHOP: userType1 = UserType.SHOP;
            break;
            case USER: userType1 = UserType.USER;
            break;
            case ADMIN: userType1 = UserType.ADMIN;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + userType );
        }

        return userType1;
    }

    protected com.mtg.deckapp.domain.model.user.UserStatus userStatusToUserStatus(UserStatus userStatus) {
        if ( userStatus == null ) {
            return null;
        }

        com.mtg.deckapp.domain.model.user.UserStatus userStatus1;

        switch ( userStatus ) {
            case PENDING_ACTIVATION: userStatus1 = com.mtg.deckapp.domain.model.user.UserStatus.PENDING_ACTIVATION;
            break;
            case ACTIVE: userStatus1 = com.mtg.deckapp.domain.model.user.UserStatus.ACTIVE;
            break;
            case SUSPENDED: userStatus1 = com.mtg.deckapp.domain.model.user.UserStatus.SUSPENDED;
            break;
            case BANNED: userStatus1 = com.mtg.deckapp.domain.model.user.UserStatus.BANNED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + userStatus );
        }

        return userStatus1;
    }

    protected com.mtg.deckapp.infrastructure.adapters.db.entities.user.UserType userTypeToUserType1(UserType userType) {
        if ( userType == null ) {
            return null;
        }

        com.mtg.deckapp.infrastructure.adapters.db.entities.user.UserType userType1;

        switch ( userType ) {
            case CREATOR: userType1 = com.mtg.deckapp.infrastructure.adapters.db.entities.user.UserType.CREATOR;
            break;
            case SHOP: userType1 = com.mtg.deckapp.infrastructure.adapters.db.entities.user.UserType.SHOP;
            break;
            case USER: userType1 = com.mtg.deckapp.infrastructure.adapters.db.entities.user.UserType.USER;
            break;
            case ADMIN: userType1 = com.mtg.deckapp.infrastructure.adapters.db.entities.user.UserType.ADMIN;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + userType );
        }

        return userType1;
    }

    protected UserStatus userStatusToUserStatus1(com.mtg.deckapp.domain.model.user.UserStatus userStatus) {
        if ( userStatus == null ) {
            return null;
        }

        UserStatus userStatus1;

        switch ( userStatus ) {
            case PENDING_ACTIVATION: userStatus1 = UserStatus.PENDING_ACTIVATION;
            break;
            case ACTIVE: userStatus1 = UserStatus.ACTIVE;
            break;
            case SUSPENDED: userStatus1 = UserStatus.SUSPENDED;
            break;
            case BANNED: userStatus1 = UserStatus.BANNED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + userStatus );
        }

        return userStatus1;
    }
}
