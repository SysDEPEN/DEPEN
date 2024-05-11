/** @type {import('next').NextConfig} */
const nextConfig = {
  async redirects() {
    return [
      {
        source: "/envio-documentos",
        destination: "/send-form",
        permanent: true,
      },
    ];
  },
};

export default nextConfig;
