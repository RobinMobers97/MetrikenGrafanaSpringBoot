FROM nginx:latest
HEALTHCHECK --interval=10s --timeout=10s --start-period=120s --retries=3 CMD curl --fail http://localhost:80/healthcheck || exit 1

COPY nginx/backend.conf /etc/nginx/conf.d/backend.conf
COPY nginx/nginx.conf /etc/nginx/nginx.conf

COPY docker-entrypoint.sh /usr/local/bin/
ENTRYPOINT ["/usr/local/bin/docker-entrypoint.sh"]
CMD ["nginx", "-g", "daemon off;"]

