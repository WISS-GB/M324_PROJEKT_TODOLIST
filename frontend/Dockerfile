# Use the official Nginx image as the base image
FROM nginx:latest

# Set the working directory
WORKDIR /usr/share/nginx/html

# Copy the contents of the public directory to the Nginx HTML directory
COPY build/ .

# Expose port 80 to allow access to the web server
EXPOSE 80

# Start Nginx server
CMD ["nginx", "-g", "daemon off;"]