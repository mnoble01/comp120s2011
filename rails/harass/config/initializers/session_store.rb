# Be sure to restart your server when you modify this file.

# Your secret key for verifying cookie session data integrity.
# If you change this key, all old sessions will become invalid!
# Make sure the secret is at least 30 characters and all random, 
# no regular words or you'll be exposed to dictionary attacks.
ActionController::Base.session = {
  :key         => '_harass_session',
  :secret      => 'cd9128e8b2f22a115d933889473a1505cf0c1be443cb9ef7f4e234e94386891b1ea4fd1fdc2f4d89879e7043d30329b0b479088024f8903de895ceaf4ee3a123'
}

# Use the database for sessions instead of the cookie-based default,
# which shouldn't be used to store highly confidential information
# (create the session table with "rake db:sessions:create")
# ActionController::Base.session_store = :active_record_store
